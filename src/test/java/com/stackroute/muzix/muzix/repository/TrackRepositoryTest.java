package com.stackroute.muzix.muzix.repository;
import com.stackroute.muzix.muzix.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@DataJpaTest
public class TrackRepositoryTest {

    @Autowired
    TrackRepository trackRepository;

    Track track;

    @Before
    public void setUp()
    {
        track = new Track();
        track.setTrackId(10);
        track.setTrackName("John");
        track.setTrackComment("hgdsksa");

    }

    @After
    public void tearDown(){

        trackRepository.deleteAll();
    }


    @Test
    public void testSaveTrack(){
        trackRepository.save(track);
        Track fetchUser = trackRepository.findById(track.getTrackId()).get();
        Assert.assertEquals(10,fetchUser.getTrackId());

    }

    @Test
    public void testSaveTrackFailure(){
        Track testTrack = new Track(1,"john","Harry123");
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getTrackId()).get();
        Assert.assertNotSame(testTrack,track);
    }

    @Test
    public void testGetAllTrack(){
        Track t = new Track(12,"Jenny","Johny12");
        Track t1 = new Track(13,"Jenny","Harry12");
        trackRepository.save(t);
        trackRepository.save(t1);

        List<Track> list = trackRepository.findAll();
        Assert.assertEquals(12,list.get(0).getTrackId());


    }
    @Test
    public void testUpdateUserSuccess()
    {
        Track testUser=trackRepository.save(track);
        Track updatetrack=new Track();
        updatetrack.setTrackId(testUser.getTrackId());
        updatetrack.setTrackName(testUser.getTrackName());
        updatetrack.setTrackComment(testUser.getTrackComment());
        Track savedTrack=trackRepository.save(updatetrack);
        Track newTrack=trackRepository.findById(savedTrack.getTrackId()).get();
        Assert.assertNotSame(updatetrack,newTrack);
    }

    @Test
    public void testUpdateUserFailure()
    {
        Track testUser=trackRepository.save(track);
        Track updatetrack=new Track();
        updatetrack.setTrackId(testUser.getTrackId());
        updatetrack.setTrackName(testUser.getTrackName());
        updatetrack.setTrackComment(testUser.getTrackComment());
        Track savedTrack=trackRepository.save(updatetrack);
        Track newtrack=trackRepository.findById(savedTrack.getTrackId()).get();
        Assert.assertNotSame(updatetrack,newtrack);
    }


}
