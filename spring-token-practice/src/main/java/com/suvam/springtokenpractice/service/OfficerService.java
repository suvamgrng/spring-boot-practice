package com.suvam.springtokenpractice.service;

import com.suvam.springtokenpractice.model.Officer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfficerService {

    public List<Officer> officers = new ArrayList<>(List.of(
            new Officer(
                    1,
                    "Suvam",
                    19
            ),
            new Officer(
                    2,
                    "Samir",
                    20
            )
    ));

    //Returns the list of officers
    public List<Officer> getOfficers() {
        return officers;
    }

    //Add a officer
    public Officer addOfficer(Officer officer) {
        if (officer.i)
        officers.add(officer);
    }
}
