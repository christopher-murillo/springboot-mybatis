package com.mitocode.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mitocode.model.Patient;

@Mapper
public interface PatientMapper {

	@Insert("INSERT INTO patient(firstname,lastname,dni,numberclinicalhistory) "
			+ "VALUES (#{firstName}, #{lastName}, #{dni}, #{numberClinicalHistory})")
	@Options(useGeneratedKeys = true, keyProperty = "idPatient", keyColumn = "idpatient")
	Integer registrar(Patient patient);

	@Update("UPDATE patient SET firstname = #{firstName}, lastname = #{lastName}, dni = #{dni}, numberclinicalhistory = #{numberClinicalHistory}"
			+ "WHERE idpatient = #{idPatient}")
	Integer actualizar(Patient patient);

	@Delete("DELETE FROM patient WHERE idpatient= #{idPatient}")
	Integer eliminar(@Param("idPatient") Integer idPatient);

	@Select("SELECT * FROM patient WHERE idpatient = #{idPatient}")
	Patient obtenerPorId(@Param("idPatient") Integer idPatient);

	// @Select("SELECT * FROM patient")
	// List<Patient> obtenerPatients();
}