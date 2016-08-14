package br.com.yuri.cerveja.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.yuri.cerveja.model.Beer;

@Repository
public interface Beers extends JpaRepository<Beer, Long>{
	public Optional<Beer> findBySkuIgnoreCase(String sku);
}
