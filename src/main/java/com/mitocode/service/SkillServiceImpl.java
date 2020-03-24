package com.mitocode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.mapper.SkillMapper;
import com.mitocode.model.Skill;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillMapper skillMapper;

	@Override
	public Integer registrar(Skill skill) {
		// TODO Auto-generated method stub
		return skillMapper.registrar(skill);
	}

}
