package br.edu.ifpb.mt.tt;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class UserServiceTest {
	
	private UserService us;
	
	private UserDAO mock;
	
	@Before
	public void setUp() throws Exception {
		us = new UserService();
		mock = mock(UserDAO.class);
		us.setUserDAO(mock);
	}
	
	@Test
	public void recuperarUsuarioPeloIdUsuarioExistente() {
		
		// preparar
		Integer id = 0;
		User user = new User();
		user.setId(id);
		user.setEmail("joao@gmail.com");
		user.setFirstName("João");
		user.setLastName("Francisco");
		user.setBirthday(new Date());
		
		when(mock.getByID(id)).thenReturn(user);
		
		// exercitar o código
		User retorno = us.getByID(id);
		
		// checar resultado
		assertEquals("Usuário diferente do esperado.", user, retorno);
		
	}
	
	@Test
	public void recuperarUsuarioPeloIdUsuarioInexistente() {
		
		// preparar
		int userId = 0;
		when(mock.getByID(userId)).thenReturn(null);
		
		// exercitar o código
		User user = us.getByID(userId);

		// checar resultado
		assertNull("Resultado deveria ser nulo.", user);
	}

}
