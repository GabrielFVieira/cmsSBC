package com.gabrielfigueiredo.cms.service;

import java.util.List;

import com.gabrielfigueiredo.cms.dto.ActivityInputDTO;
// import com.gabrielfigueiredo.cms.dto.ActivityOrganizerInputDTO;
import com.gabrielfigueiredo.cms.model.Activity;
import com.gabrielfigueiredo.cms.dto.ActivityDTO;

public interface ActivityService {
	public ActivityDTO create(ActivityInputDTO input);

	public ActivityDTO find(Integer id);

	public Activity findEntity(Integer id);

	public List<ActivityDTO> list();

	public ActivityDTO update(Integer id, ActivityInputDTO input);

	public void remove(Integer id);
}
