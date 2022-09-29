package com.salesForce.service;

import com.salesForce.entity.Profile;
import com.salesForce.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class ProfileService {
    private ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile createProfile (Profile profile){
        return profileRepository.save(profile);
    }

    public Profile findProfileByEmail (String email){
        return profileRepository.findByEmail(email);
    }

    public List<Profile> findProfiles() {
        return new ArrayList<Profile>(profileRepository.findAll());
    }
    public Profile getOrCreateProfile(Map<String,Object> profileData) {
        String email = (String) profileData.get("email");
        Profile profile = findProfileByEmail(email);
        if (profile == null) {
            String name = (String) profileData.get("nickname");
            String image = (String) profileData.get("picture");
            String auth0Id = (String) profileData.get("sub");
            Profile newProfile = new Profile(name=name, email=email, image=image, auth0Id=auth0Id);
            return createProfile(newProfile);
        }
        return profile;
    }

    public void deleteProfile (Long id_profile){
        profileRepository.deleteById(id_profile);
    }

}
