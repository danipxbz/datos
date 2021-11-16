package flujos2;

import java.util.Objects;

public class videojuego {

	private String tittle;
	private String gen;
	private int year;
	private String plataform;
	private String resume;
	
	public videojuego() {
		
	}
	
	public videojuego(String tittle, String gen, int year, String plataform, String resume) {
		super();
		this.tittle = tittle;
		this.gen = gen;
		this.year = year;
		this.plataform = plataform;
		this.resume = resume;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getGen() {
		return gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPlataform() {
		return plataform;
	}

	public void setPlataform(String plataform) {
		this.plataform = plataform;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "videojuego [tittle=" + tittle + "// gen=" + gen + "// year=" + year + "// plataform=" + plataform
				+ "// resume=" + resume + "]\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(tittle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		videojuego other = (videojuego) obj;
		return Objects.equals(gen, other.gen) && Objects.equals(plataform, other.plataform)
				&& Objects.equals(resume, other.resume) && Objects.equals(tittle, other.tittle) && year == other.year;
	}
}
