package com.constructora.service;

import java.util.List;

import com.constructora.model.Menu;


public interface IMenuService extends ICRUD<Menu> {
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
