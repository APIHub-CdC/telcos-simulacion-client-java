package io.TelcosSimulacion.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Datos generales de la persona a consultar.")
public class Peticion {

	@SerializedName("folioOtorgante")
	private String folioOtorgante;

	@SerializedName("persona")
	private PersonaPeticion persona;

	public String getFolioOtorgante() {
		return folioOtorgante;
	}

	public void setFolioOtorgante(String folioOtorgante) {
		this.folioOtorgante = folioOtorgante;
	}

	public PersonaPeticion getPersona() {
		return persona;
	}

	public void setPersona(PersonaPeticion persona) {
		this.persona = persona;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Peticion peticion = (Peticion) o;
		return Objects.equals(this.folioOtorgante, peticion.folioOtorgante)
				&& Objects.equals(this.persona, peticion.persona);
	}

	@Override
	public int hashCode() {
		return Objects.hash(folioOtorgante, persona);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Peticion {\n");

		sb.append("    folioOtorgante: ").append(toIndentedString(folioOtorgante)).append("\n");
		sb.append("    persona: ").append(toIndentedString(persona)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
