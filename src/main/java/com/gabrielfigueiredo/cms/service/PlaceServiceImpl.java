package com.gabrielfigueiredo.cms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gabrielfigueiredo.cms.dto.PlaceDTO;
import com.gabrielfigueiredo.cms.dto.PlaceInputDTO;
import com.gabrielfigueiredo.cms.exception.DomainException;
import com.gabrielfigueiredo.cms.exception.InvalidParamException;
import com.gabrielfigueiredo.cms.exception.NotFoundException;
import com.gabrielfigueiredo.cms.exception.ServerException;
import com.gabrielfigueiredo.cms.model.Place;
import com.gabrielfigueiredo.cms.repository.PlaceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {
	private final PlaceRepository repository;

	@Override
	public PlaceDTO create(PlaceInputDTO input) {
		try {
			Place entity = new Place(input);
			entity.Validate();

			Place savedEntity = repository.save(entity);
			PlaceDTO dto = new PlaceDTO(savedEntity);

			return dto;
		}  catch (InvalidParamException | DomainException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while creating place");
		}
	}

	@Override
	public List<PlaceDTO> list() {
		try {
			List<Place> Places = repository.findAll();

			List<PlaceDTO> dtos = new ArrayList<>();
			for (Place Place : Places) {
				dtos.add(new PlaceDTO(Place));
			}

			return dtos;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while listing places");
		}
	}

	@Override
	public PlaceDTO update(Integer id, PlaceInputDTO input) {
		try {
			Place entity = findById(id);
			entity.Merge(input);
			entity.Validate();

			Place updatedEntity = repository.save(entity);
			PlaceDTO dto = new PlaceDTO(updatedEntity);

			return dto;
		}  catch (InvalidParamException | DomainException | NotFoundException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while updating place");
		}
	}

	@Override
	public void remove(Integer id) {
		try {
			Place entity = findById(id);
			repository.delete(entity);

			return;
		}  catch (InvalidParamException | DomainException | NotFoundException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while deleting place");
		}
	}

	@Override
	public PlaceDTO find(Integer id) {
		try {
			Place entity = findById(id);
			PlaceDTO dto = new PlaceDTO(entity);

			return dto;
		}  catch (NotFoundException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while fetching place");
		}
	}

	private Place findById(Integer id) {
		Optional<Place> exists = repository.findById(id);

		if (!exists.isPresent()) {
			throw new NotFoundException("Place '"+id+"' not found");
		}

		return exists.get();
	}

	@Override
	public Place findEntity(Integer id) {
		try {
			Place entity = findById(id);

			return entity;
		}  catch (NotFoundException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while fetching place");
		}
	}
}
