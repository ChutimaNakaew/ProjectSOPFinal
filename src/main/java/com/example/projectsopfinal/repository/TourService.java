package com.example.projectsopfinal.repository;

import com.example.projectsopfinal.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TourService {
    private TourRepository tourRepository;

    @Autowired
    public TourService(TourRepository tourRepository){
        this.tourRepository = tourRepository;
    }
    public Tour saveTour(Tour tour){
        return tourRepository.save(tour);
    }

    public Iterable<Tour> getAllTours(){
        return tourRepository.findAll();
    }

    public void deleteAllTours(){
        tourRepository.deleteAll();
    }

    public Tour detailTourByName(String name){
        return tourRepository.findByName(name);
    }

    public void deleteTourById(String id){
        tourRepository.deleteById(id);
    }

    public Optional<Tour> findTourById(String id){
        return tourRepository.findById(id);
    }

    public Iterable<Tour> getToursByProvince(String province){
        return tourRepository.findByProvince(province);
    }

    public Tour getTourById(String id){
        Optional<Tour> optional = tourRepository.findById(id);
        Tour tour = null;
        if(optional.isPresent()){
            tour = optional.get();
        }else{
            throw new RuntimeException("Tour not found for id ::"+ id);
        }
        return tour;
    }
    public void chageName(String id ,String name, String province)
    {
        Tour t = new Tour();
        t = tourRepository.findById(id).get();
        t.setName(name);
        t.setProvince(province);
        tourRepository.save(t);
    }
}
