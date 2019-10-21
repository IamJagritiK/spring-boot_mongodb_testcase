package com.stackroute.service;

import com.stackroute.domain.Muzix;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.repository.MuzixRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MuzixServiceTest {

    private Muzix muzix;

    //Create a mock for UserRepository
    @Mock
    private MuzixRepository muzixRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private MuzixServiceImpl muzixService;
    List<Muzix> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        muzix = new Muzix();
        muzix.setName("John");
        muzix.setId(101);
        muzix.setComments("Jenny");
        muzix.setRating(10);
        list = new ArrayList<>();
        list.add(muzix);


    }


    @Test
    public void saveTracks() {
        when(muzixRepository.save((Muzix)any())).thenReturn(muzix);
        Muzix savedUser = muzixService.saveTracks(muzix);
        Assert.assertEquals(muzix,savedUser);

        //verify here verifies that userRepository save method is only called once
        verify(muzixRepository,times(1)).save(muzix);

    }





    @Test
    public void getAlltracks() {
        muzixRepository.save(muzix);
        //stubbing the mock to return specific data
        when(muzixRepository.findAll()).thenReturn(list);
        List<Muzix> userlist = muzixService.getAlltracks();
        Assert.assertEquals(list,userlist);


    }
}