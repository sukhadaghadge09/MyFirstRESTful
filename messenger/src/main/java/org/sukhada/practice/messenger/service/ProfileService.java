package org.sukhada.practice.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.sukhada.practice.messenger.database.DatabaseClass;
import org.sukhada.practice.messenger.model.Message;
import org.sukhada.practice.messenger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles=DatabaseClass.getProfile();
	
	public ProfileService()
	{
		profiles.put("Sukhada",new Profile(1L,"Sukhada","Sukhada","Ghadge"));
		profiles.put("Sandhya",new Profile(2L,"Sandhya","Sukhada","Ghadge"));
	}
	
	 public List<Profile> getAllProfiles()
	 {
		 return new ArrayList<Profile>(profiles.values());
	 }
	

	public Profile getProfile(String profileName)
	{
		 return profiles.get(profileName);
	}
	
	 public Profile addProfile(Profile profile)
	 {
		 profile.setId(profiles.size()+1);
		 profiles.put(profile.getProfileName(),profile);
		 return profile;
	 }
	 
	 public Profile updateProfile(Profile profile)
	 {
		 if(profile.getProfileName()==null)
		 {
			 return null;
		 }
		 else{
			  profiles.put(profile.getProfileName(),profile);	
			  return profile;
		 }
		 
		 
	 }
	 public void removeProfile(String profileName)
	 {
		 profiles.remove(profileName);
	 }
	 
}
