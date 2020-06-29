package com.mitocode.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mitocode.model.Specialty;

@Mapper
public interface SpecialtyMapper {

	@Insert("INSERT INTO specialty(name) "
			+ "VALUES (#{name})")
	@Options(useGeneratedKeys = true, keyProperty = "idSpecialty", keyColumn = "idspecialty")
	Integer registrar(Specialty specialty);
	
	@Update("UPDATE specialty SET name = #{name} WHERE idspecialty = #{idSpecialty}")
	Integer actualizar(Specialty specialty);
	
	@Delete("DELETE FROM specialty WHERE idspecialty = #{idSpecialty}")
	Integer eliminar(@Param("idSpecialty") Integer idSpecialty);
	
	@Select("SELECT * FROM specialty WHERE idspecialty = #{idSpecialty}")
	Specialty obtenerPorId(@Param("idSpecialty") Integer idSpecialty);
	
	//@Select("SELECT * FROM specialty")
	//List<Specialty> obtenerSpecialties();
}
