package com.example.projectsopfinal.repository;

import com.example.projectsopfinal.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
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

    public Tour TourByName(String name){
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
    public void chageName(String id , String name, String province, Double price, String schedule, String img, String detail_img, String detail, LocalDate date_first, LocalDate date_second, Integer max_tourist)
    {
        Tour t = new Tour();
        t = tourRepository.findById(id).get();
        t.setName(name);
        t.setProvince(province);
        t.setPrice(price);
        t.setSchedule(schedule);
        t.setImg(img);
        t.setDetail_img(detail_img);
        t.setDetail(detail);
        t.setDate_first(date_first);
        t.setDate_second(date_second);
        t.setMax_tourist(max_tourist);
        tourRepository.save(t);
    }

//    public Iterable<Tour> getSortMinTours(){
//        return tourRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
//    }


}
