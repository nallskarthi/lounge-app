package com.qantas.lounge.model;

import java.util.List;


public class Lounge {
private HaulType haulType;
private List<LoungeAvailability> loungeAvailability;
public HaulType getHaulType() {
	return haulType;
}
public void setHaulType(HaulType haulType) {
	this.haulType = haulType;
}
public List<LoungeAvailability> getLoungeAvailability() {
	return loungeAvailability;
}
public void setLoungeAvailability(List<LoungeAvailability> loungeAvailability) {
	this.loungeAvailability = loungeAvailability;
}

}
