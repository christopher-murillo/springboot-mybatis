package com.mitocode.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mitocode.model.Skill;

@Mapper
public interface SkillMapper {

	@Select("SELECT * FROM skills WHERE idempleado = #{idEmpleado}")
	List<Skill> skillsPorEmpleado(@Param("idEmpleado") Integer idEmpleado);

	@Delete("DELETE FROM skills WHERE idempleado = #{idEmpleado}")
	Integer eliminarSkillsPorEmpleado(@Param("idEmpleado") Integer idEmpleado);

	@Insert({
        "<script>",
        "INSERT INTO skills(descripcion, idempleado)",
        "VALUES ",
        "<foreach collection='skills' item='skill' separator=','>",
        "( #{skill.descripcion,jdbcType=VARCHAR}, #{skill.empleado.idEmpleado,jdbcType=INTEGER} )",
        "</foreach>",
        "</script>"
	})
	Integer registrar(@Param("skills") List<Skill> skills);
}
