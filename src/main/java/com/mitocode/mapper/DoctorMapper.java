package com.mitocode.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mitocode.model.Doctor;
import com.mitocode.model.Specialty;

@Mapper
public interface DoctorMapper {

	@Insert("INSERT INTO doctor(firstname,lastname,dni,cmp,idspecialty) "
			+ "VALUES (#{firstName}, #{lastName}, #{dni}, #{cmp}, #{specialty.idPatient})")
	@Options(useGeneratedKeys = true, keyProperty = "idDoctor", keyColumn = "iddoctor")
	Integer registrar(Doctor doctor);

	@Update("UPDATE doctor SET firstname = #{firstName}, lastname = #{lastName}, dni = #{dni}, cmp = #{cmp}, "
			+ " idspecialty = #{specialty.idSpecialty} WHERE iddoctor = #{idDoctor}")
	Integer actualizar(Doctor doctor);

	@Delete("DELETE FROM doctor WHERE iddoctor = #{idDoctor}")
	Integer eliminar(@Param("idDoctor") Integer idDoctor);

	@Select("SELECT * FROM doctor")
	@Results(@Result(property ="specialty", javaType = Specialty.class, column="idspecialty", one= @One(select = "com.mitocode.mapper.SpecialtyMapper.obtenerSpecialty")))
	List<Doctor> obtenerDoctor();
	
	@Select("SELECT firstname,lastname,name FROM doctor")
	@Results(@Result(property ="specialty", javaType = Specialty.class, column="idspecialty", one= @One(select = "com.mitocode.mapper.SpecialtyMapper.obtenerSpecialty")))
	List<Doctor> obtenerDoctorPorEspecialidad();
//Doctor obtenerDoctor(@Param("idDoctor") Integer idDoctor);
}
