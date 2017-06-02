package br.edu.ifpb.mt.tt.assumptions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;
import static org.junit.Assert.*;

import java.io.File;
import java.util.Random;

import org.junit.Test;

public class Assumptions {

	private boolean pickRandomBoolean() {
		return new boolean[] { true, false }[new Random().nextInt(2)];
	}

	@Test
	public void filenameIncludesUsername() {
		assumeThat(File.separatorChar, is('/'));
		//assertTrue(false);
		//assertThat(new User("optimus").configFileName(), is("configfiles/optimus.cfg"));
	}
	
	@Test
	public void jogarNaMegaSena() {
		boolean comSorte = pickRandomBoolean();
		System.out.println(comSorte);
		assumeThat(comSorte, is(true));
		assumeTrue(comSorte);
		
		// jogar na mega sena...
		System.out.println("Joguei na mega sena!");
	}

}
