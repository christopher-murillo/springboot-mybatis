package com.mitocode.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mitocode.model.Doctor;
import com.mitocode.model.MedicalConsultation;
import com.mitocode.model.Patient;

@Mapper
public interface MedicalConsultationMapper {

	@Insert("INSERT INTO medicalconsultation (createdate,iddoctor,idpatient) "
			+ "VALUES (#{createDate}, #{doctor.idDoctor}, #{patient.idPatient})")
	@Options(useGeneratedKeys = true, keyProperty = "idMedicalConsultation", keyColumn = "idmedicalconsultation")
	Integer registrar(MedicalConsultation medicalconsultation);

	@Update("UPDATE medicalconsultation SET createdate = #{createDate}, iddoctor = #{doctor.idDoctor} "
			+ " idpatient = #{patient.idPatient} WHERE idmedicalconsultation = #{idMedicalConsultation}")
	Integer actualizar(MedicalConsultation medicalconsultation);

	@Delete("DELETE FROM medicalconsultation WHERE idmedicalconsultation = #{idMedicalConsultation}")
	Integer eliminar(@Param("idMedicalConsultation") Integer idMedicalConsultation);
	
	@Select("SELECT * FROM medicalconsultation WHERE idmedicalconsultation = #{idMedicalConsultation}") 
	@Results({
		@Result(property = "idMedicalConsultation", column = "idmedicalconsultation")
		,
		@Result(property = "doctor", javaType= Doctor.class, column = "iddoctor",
		many= @Many(select = "com.mitocode.mapper.DoctorMapper.obtenerDoctor"))
		,
		@Result(property = "patient", javaType= Patient.class, column = "idpatient",
		many = @Many(select = "com.mitocode.mapper.PatientMapper.obtenerPatient"))
	})
	MedicalConsultation obtenerPorId(@Param("idMedicalConsultation") Integer idMedicalConsultation);
}