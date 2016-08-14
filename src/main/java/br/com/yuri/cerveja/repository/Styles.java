package br.com.yuri.cerveja.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.yuri.cerveja.model.Style;

public interface Styles extends JpaRepository<Style, Long>{

}
