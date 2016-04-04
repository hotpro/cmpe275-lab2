package edu.sjsu.cmpe275.lab2.service;

import edu.sjsu.cmpe275.lab2.dao.ProfileDao;
import edu.sjsu.cmpe275.lab2.domain.Profile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 */
public class ProfileServiceImplMockTests {
    private static final Profile profile = new Profile(
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1"
            );

    private ProfileDao profileDao;
    private ProfileService profileService;

    @Before
    public void init() {
        profileDao = mock(ProfileDao.class);
        profileService = new ProfileServiceImpl(profileDao);
    }

    @Test
    public void store() {
        when(profileDao.store(profile)).thenReturn(profile);

        Profile p = profileService.store(profile);

        assertEquals(p.getId(), profile.getId());
        verify(profileDao, times(1)).store(profile);
    }

    @Test
    public void findById() {
        when(profileDao.findById(profile.getId())).thenReturn(profile);

        Profile p = profileService.findById(profile.getId());

        assertEquals(p.getId(), profile.getId());
        verify(profileDao, times(1)).findById(profile.getId());

    }

    @Test
    public void delete() {
        when(profileDao.delete(profile.getId())).thenReturn(profile);

        Profile p = profileService.delete(profile.getId());

        assertEquals(p.getId(), profile.getId());
        verify(profileDao, times(1)).delete(profile.getId());
    }
}

