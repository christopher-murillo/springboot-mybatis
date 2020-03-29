package com.mitocode.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mitocode.service.EmpleadoService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/reportes")
public class ReporteController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@ModelAttribute("module")
    String module() {
        return "reportes";
    }

	@GetMapping()
	public String reportForm() {
		return "reportes";
	}

	@GetMapping("/reporte01")
	public ResponseEntity<byte[]> reporte01() throws JRException, IOException {

		JasperReport report = JasperCompileManager.compileReport("src/main/resources/reportes/Reporte01.jrxml");
		JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(empleadoService.obtenerEmpleados());
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("parametro1", "Hola Mundo");
		JasperPrint print = JasperFillManager.fillReport(report, parameters, source);
		byte[] data = JasperExportManager.exportReportToPdf(print);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename= " + "empleados.pdf")
				.contentType(MediaType.APPLICATION_PDF)
				.contentLength(data.length)
				.body(data);
	}

}
