package com.gabrielfigueiredo.cms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gabrielfigueiredo.cms.dto.ActivityDTO;
import com.gabrielfigueiredo.cms.dto.ActivityInputDTO;
import com.gabrielfigueiredo.cms.exception.DomainException;
import com.gabrielfigueiredo.cms.exception.InvalidParamException;
import com.gabrielfigueiredo.cms.exception.NotFoundException;
import com.gabrielfigueiredo.cms.exception.ServerException;
import com.gabrielfigueiredo.cms.model.Activity;
import com.gabrielfigueiredo.cms.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {
	private final ActivityRepository repository;

	@Override
	public ActivityDTO create(ActivityInputDTO input) {
		try {
			Activity entity = new Activity(input);
			entity.Validate();

			Activity savedEntity = repository.save(entity);
			ActivityDTO dto = new ActivityDTO(savedEntity);

			return dto;
		}  catch (InvalidParamException | DomainException e) {
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
			Activity entity = findById(id);
			entity.Merge(input);
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