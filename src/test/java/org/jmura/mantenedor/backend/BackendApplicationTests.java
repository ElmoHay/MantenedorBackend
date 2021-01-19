package org.jmura.mantenedor.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.jmura.mantenedor.backend.models.Tarea;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BackendApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	//prueba unitaria: insertar tarea y checkear status http 201 (created)
	@Test
	public void shouldInsertOneTaskAndGetStatus201() throws Exception{
		Tarea tarea =new Tarea();
		tarea.setDescripcion("tarea test");
		tarea.setFechaCreacion(new Date(1611014400000L));
		tarea.setVigente(true);

		this.mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/tareas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(tarea)))
		.andExpect(status().isCreated());
	}

	//prueba unitaria: leer tarea y comparar descripción, fechaCreacion y vigente.

	@Test
	public void readTaskAndCompareEquals() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/tareas/1")
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isFound())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.descripcion").value("Despachar productos a domicilio"))
			.andExpect(jsonPath("$.fechaCreacion").value("2020-12-31"))
			.andExpect(jsonPath("$.vigente").value("true"));
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
