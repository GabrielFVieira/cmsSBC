package com.gabrielfigueiredo.cms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.gabrielfigueiredo.cms.dto.ActivityDTO;
import com.gabrielfigueiredo.cms.dto.ActivityInputDTO;
import com.gabrielfigueiredo.cms.dto.PlaceDTO;
import com.gabrielfigueiredo.cms.exception.DomainException;
import com.gabrielfigueiredo.cms.exception.InvalidParamException;
import com.gabrielfigueiredo.cms.exception.NotFoundException;
import com.gabrielfigueiredo.cms.exception.ServerException;
import com.gabrielfigueiredo.cms.model.Activity;
import com.gabrielfigueiredo.cms.model.Edition;
import com.gabrielfigueiredo.cms.model.Place;
import com.gabrielfigueiredo.cms.repository.ActivityRepository;

@Service
public class ActivityServiceImpl implements ActivityService {
	private final ActivityRepository repository;
	private final PlaceService placeService;
	private final EditionService editionService;

    public ActivityServiceImpl(ActivityRepository repo, PlaceService placeService, @Lazy EditionService editionService) {
        this.repository = repo;
		this.placeService = placeService;
		this.editionService = editionService;
    }

	@Override
	public ActivityDTO create(ActivityInputDTO input) {
		try {
			Place place = placeService.findEntity(input.getIdLocal());
			Edition edition = editionService.findEntity(input.getIdEdicao());

			Activity entity = new Activity(input);
			entity.setLocal(place);
			entity.setEdicao(edition);
			entity.Validate();

			Activity savedEntity = repository.save(entity);
			ActivityDTO dto = new ActivityDTO(savedEntity);

			PlaceDTO placeDTO = new PlaceDTO(savedEntity.getLocal());
			dto.setPlace(placeDTO);

			return dto;
		}  catch (InvalidParamException | NotFoundException | DomainException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while creating activity");
		}
	}

	@Override
	public List<ActivityDTO> list() {
		try {
			List<Activity> activitys = repository.findAll();

			List<ActivityDTO> dtos = new ArrayList<>();
			for (Activity activity : activitys) {
				dtos.add(new ActivityDTO(activity));
			}

			return dtos;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while listing activitys");
		}
	}

	@Override
	public ActivityDTO update(Integer id, ActivityInputDTO input) {
		try {
			Place place = placeService.findEntity(input.getIdLocal());

			Activity entity = findById(id);

			if (!input.getIdEdicao().equals(entity.getEdicao().getId())) {
				throw new DomainException("Cannot change the edition of an activiy");
			}

			entity.Merge(input);
			entity.setLocal(place);
			entity.Validate();

			Activity updatedEntity = repository.save(entity);
			ActivityDTO dto = new ActivityDTO(updatedEntity);

			return dto;
		}  catch (InvalidParamException | DomainException | NotFoundException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while updating activity");
		}
	}

	@Override
	public void remove(Integer id) {
		try {
			Activity entity = findById(id);
			repository.delete(entity);

			return;
		}  catch (InvalidParamException | DomainException | NotFoundException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while deleting activity");
		}
	}

	@Override
	public ActivityDTO find(Integer id) {
		try {
			Activity entity = findById(id);
			ActivityDTO dto = new ActivityDTO(entity);

			return dto;
		}  catch (NotFoundException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while fetching activity");
		}
	}

	private Activity findById(Integer id) {
		Optional<Activity> exists = repository.findById(id);

		if (!exists.isPresent()) {
			throw new NotFoundException("Activity '"+id+"' not found");
		}

		return exists.get();
	}

	@Override
	public Activity findEntity(Integer id) {
		try {
			Activity entity = findById(id);

			return entity;
		}  catch (NotFoundException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while fetching activity");
		}
	}

}