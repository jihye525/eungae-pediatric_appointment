package com.playdata.eungae.hospital.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playdata.eungae.hospital.domain.Hospital;
import com.playdata.eungae.hospital.dto.HospitalRegisterRequestDto;
import com.playdata.eungae.hospital.dto.HospitalViewResponseDto;
import com.playdata.eungae.hospital.repository.HospitalRepository;
import com.playdata.eungae.hospital.repository.HospitalScheduleRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HospitalService{
	private final HospitalRepository hospitalRepository;
	private final HospitalScheduleRepository hospitalScheduleRepository;

	@Transactional(readOnly = true)
	public void saveHospital(HospitalRegisterRequestDto dto) {
		Hospital entity = HospitalRegisterRequestDto.toEntity(dto);
		hospitalRepository.save(entity);
		hospitalScheduleRepository.save(entity.getHospitalSchedule());
	}




}
