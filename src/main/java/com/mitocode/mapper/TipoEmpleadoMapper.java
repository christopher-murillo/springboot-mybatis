package com.mitocode.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mitocode.model.TipoEmpleado;

@Mapper
public interface TipoEmpleadoMapper {

	@Select("SELECT * FROM tipoempleado WHERE idtipoempleado = #{idTipoEmpleado}")
	TipoEmpleado obtenerTipo(@Param("idTipoEmpleado") Integer idTipoEmpleado);

	@Select("SELECT * FROM tipoempleado")
	List<TipoEmpleado> obtenerTipos();
}
