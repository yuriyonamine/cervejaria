package br.com.yuri.cerveja.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.yuri.cerveja.model.Style;

public interface Styles extends JpaRepository<Style, Long>{
	public Optional<Style> findByNameIgnoreCase(String name);
}
