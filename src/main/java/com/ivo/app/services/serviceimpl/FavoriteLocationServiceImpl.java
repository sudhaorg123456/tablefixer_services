package com.ivo.app.services.serviceimpl;

import com.ivo.app.services.entity.UserFavoriteLocationsXref;
import com.ivo.app.services.repository.UserFavoriteLocationsXrefRepository;
import com.ivo.app.services.service.FavoriteLocationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteLocationServiceImpl implements FavoriteLocationService {
	private static final Logger logger = LogManager.getLogger(FavoriteLocationServiceImpl.class);
	@Autowired
	private UserFavoriteLocationsXrefRepository userFavoriteLocationsXrefRepository;

	@Override
	public UserFavoriteLocationsXref createUserFavoriteLocation(String userUUID, String locationUUID) {

		UserFavoriteLocationsXref userFavoriteLocationsXref = new UserFavoriteLocationsXref();

		userFavoriteLocationsXref.setUserUuid(userUUID);
		userFavoriteLocationsXref.setLocationUuid(locationUUID);
		userFavoriteLocationsXref.setInsrtBy(userUUID);
		userFavoriteLocationsXref.setUpdtBy(userUUID);

		return userFavoriteLocationsXrefRepository.save(userFavoriteLocationsXref);
	}

	@Override
	public long deleteUserFavoriteLocation(String userUUID, String locationUUID) {
		return userFavoriteLocationsXrefRepository.deleteByUserUuidAndLocationUuid(userUUID,  locationUUID);
	}

}
