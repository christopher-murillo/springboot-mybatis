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

import com.mitocode.model.DetailConsultation;
import com.mitocode.model.MedicalConsultation;

@Mapper
public interface DetailConsultationMapper {

	@Insert("INSERT INTO detailconsultation (diagnostic,treatment,idmedicalconsultation) "
			+ "VALUES (#{diagnostic}, #{treatment}, #{medicalConsultation.idMedicalConsultation})")
	@Options(useGeneratedKeys = true, keyProperty = "idDetailConsultation", keyColumn = "iddetailconsultation")
	Integer registrar(DetailConsultation detailConsultation);

	@Update("UPDATE detailconsultation SET diagnostic = #{diagnostic}, treatment = #{treatment} "
			+ " idmedicalconsultation = #{medicalConsultation.idMedicalConsultation} WHERE iddetailconsultation = #{idDetailConsultation}")
	Integer actualizar(DetailConsultation detailConsultation);

	@Delete("DELETE FROM detailconsultation WHERE iddetailconsultation = #{idDetailConsultation}")
	Integer eliminar(@Param("idDetailConsultation") Integer idDetailConsultation);
	
	@Select("SELECT * FROM detailconsultation") 
	@Results(@Result(property = "medicalConsultation", javaType= MedicalConsultation.class, column = "idmedicalconsultation", one= @One(select = "com.mitocode.mapper.MedicalConsultation.obtenerMedicalConsultation")))
	List<DetailConsultation> obtenerDetailConsultation();
}
