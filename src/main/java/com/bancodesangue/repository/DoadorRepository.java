package com.bancodesangue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bancodesangue.model.Doador;
import com.bancodesangue.model.custom.DoadorGenero;
import com.bancodesangue.model.custom.DoadorPorEstado;
import com.bancodesangue.model.custom.DoadorPossivel;




public interface DoadorRepository extends CrudRepository<Doador, String>{
	
	Doador findByCodigo (long codigo);
	//Iterable<Doador> findByDoador(Doador doador);
	
//	@Query("select d from  Doador d  where estado = 'SE'")
//	List<Doador> findAllDoadorPorEstado();
	
	//@Query("select  d.estado, Count(estado) as qtde from doador d\r\n"
	//		+ "group by estado ")
   // List<Doador> findAllDoadorPorEstado();
	
	@Query("SELECT new com.bancodesangue.model.custom.DoadorPorEstado(d.estado, COUNT(d.estado)) FROM Doador as d GROUP BY d.estado")
    List<DoadorPorEstado> findAllDoadorPorEstado();
	
	@Query("SELECT new com.bancodesangue.model.custom.DoadorPossivel (d.tipo_sanguineo as TipoSanguineo, count(*) -1 as PossiveisDoadores) from Doador d "
			+ "where tipo_sanguineo = 'A+' or tipo_sanguineo = 'A-' or tipo_sanguineo = 'O+' or tipo_sanguineo = 'O-' and peso > 50")
	List<DoadorPossivel> findAllDoadoesPossiveisA();
	
	@Query("SELECT new com.bancodesangue.model.custom.DoadorPossivel (d.tipo_sanguineo as TipoSanguineo, count(*) -1 as PossiveisDoadores) from Doador d "
			+ "where tipo_sanguineo = 'A-' or tipo_sanguineo = 'O-' and peso > 50")
	List<DoadorPossivel> findAllDoadoesPossiveisAN();
	
	@Query("SELECT new com.bancodesangue.model.custom.DoadorPossivel (d.tipo_sanguineo as TipoSanguineo, count(*) -1 as PossiveisDoadores) from Doador d "
			+ "where tipo_sanguineo = 'B+' or tipo_sanguineo = 'B-' or tipo_sanguineo = 'O+' or tipo_sanguineo = 'O-' and peso > 50")
	List<DoadorPossivel> findAllDoadoesPossiveisB();
	
	@Query("SELECT new com.bancodesangue.model.custom.DoadorPossivel (d.tipo_sanguineo as TipoSanguineo, count(*) -1 as PossiveisDoadores) from Doador d "
			+ "where tipo_sanguineo = 'O-' or tipo_sanguineo = 'B-'  and peso > 50")
	List<DoadorPossivel> findAllDoadoesPossiveisBN();
	
	@Query("SELECT new com.bancodesangue.model.custom.DoadorPossivel (d.tipo_sanguineo as TipoSanguineo, count(*) -1 as PossiveisDoadores) from Doador d "
			+ "where tipo_sanguineo = 'AB-' or tipo_sanguineo = 'AB+' or tipo_sanguineo = 'A-' or tipo_sanguineo = 'A+' or tipo_sanguineo = 'B+' or tipo_sanguineo = 'B-' or tipo_sanguineo = 'O+' or tipo_sanguineo = 'O-' and peso > 50")
	List<DoadorPossivel> findAllDoadoesPossiveisAB();
	
	@Query("SELECT new com.bancodesangue.model.custom.DoadorPossivel (d.tipo_sanguineo as TipoSanguineo, count(*) -1 as PossiveisDoadores) from Doador d "
			+ "where tipo_sanguineo = 'A-' or tipo_sanguineo = 'B-' or tipo_sanguineo = 'AB-' or tipo_sanguineo = 'O-' and peso > 50")
	List<DoadorPossivel> findAllDoadoesPossiveisABN();
	
	@Query("SELECT new com.bancodesangue.model.custom.DoadorPossivel (d.tipo_sanguineo as TipoSanguineo, count(*) -1 as PossiveisDoadores) from Doador d "
			+ "where tipo_sanguineo = 'O-' or tipo_sanguineo = 'O+' and peso > 50")
	List<DoadorPossivel> findAllDoadoesPossiveisO();
	
	@Query("SELECT new com.bancodesangue.model.custom.DoadorPossivel (d.tipo_sanguineo as TipoSanguineo, count(*) -1 as PossiveisDoadores) from Doador d "
			+ "where tipo_sanguineo = 'O-' and peso > 50")
	List<DoadorPossivel> findAllDoadoesPossiveisON();
	
	@Query("SELECT new com.bancodesangue.model.custom.DoadorGenero (d.sexo as sexo, ((count(*)*10)/100) as qtde) from Doador d where (peso/altura+altura) > 30 and sexo = 'Feminino' ")
	List<DoadorGenero> findAllFeminino();
	
	@Query("SELECT new com.bancodesangue.model.custom.DoadorGenero (d.sexo as sexo, ((count(*)*10)/100) as qtde) from Doador d where (peso/altura+altura) > 30 and sexo = 'Masculino' ")
	List<DoadorGenero> findAllMasculino();
	
}