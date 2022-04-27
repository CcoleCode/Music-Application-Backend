package com.example.music;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.music.model.Music;
import com.example.music.repository.MusicRepository;

@SpringBootTest

public class SpringbootJunitApplicationTest {

	@Autowired
	MusicRepository mRepo;
	
	@Test
	@Order(1)
	public void testCreate() {
		Music m = new Music();
		m.setTrackId(6L);
		m.setTrackName("Mr.Telephone Man");
		m.setArtistName("New Edition");
		m.setDuration(250);
		mRepo.save(m);
		assertNotNull(mRepo.findById(6L).get());
	}
	
	/*@Test
	 @Order(2)
	public void testReadAll() {
		List<Music> list = mRepo.findAll();
		assertEquals(list).size().isGreaterThan(0);
	}
	*/
	
	@Test
	@Order(3)
	public void testSingleTrack () {
		Music music = mRepo.findById(6L).get();
		assertEquals(250, music.getDuration());
	}
	
	@Test
	@Order(4)
	public void testUpdate() {
		Music m = mRepo.findById(6L).get();
		m.setDuration(250);
		mRepo.save(m);
		assertNotEquals(250, mRepo.findById(6L).get().getDuration());
	}
	
	/*@Test
	@Order(5)
	public void testDelete() {
		mRepo.deleteById(6L);
		assertThat(mRepo.existsById(6L)).isFalse();
	}
*/
	
}
