package com.example.eventsystem.EventController;

import com.example.eventsystem.ApiResponse.ApiResponse;
import com.example.eventsystem.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    ArrayList<Event> events = new ArrayList<Event>();

    @GetMapping("/getEvent")
    public ArrayList<Event> getEvent() {
        return events;
    }

    @PostMapping("/addEvent")
    public ApiResponse addEvent(@RequestBody Event event) {
        events.add(event);
        return new ApiResponse("Success Added Event");
    }

    @PutMapping("/updateEvent/{id}")
    public ApiResponse updateEvent(@PathVariable int id, @RequestBody Event event) {

        for (Event loop : events) {
            if (loop.getId() == id) {
                events.set(id,event);
                return new ApiResponse("success update Event");
            }
        }

        return new ApiResponse("Event not in list");
    }

    @DeleteMapping("/deleteEvent/{id}")
    public ApiResponse deleteEvent(@PathVariable int id) {

        for (Event loop : events) {
            if (loop.getId() == id) {
                events.remove(loop);
                return new ApiResponse("Success Delete Event");
            }
        }
        return new ApiResponse("Project not in list: "+ id);
    }

    @PutMapping("/changeCapacity/{id}/{Capacity}")
    public ApiResponse changeCapacity(@PathVariable int id,@PathVariable int Capacity) {

        for (Event loop : events) {
            if (loop.getId() == id) {
                loop.setCapacity(Capacity);
                return new ApiResponse("Capacity is to: "+Capacity);
            }
        }
         return new ApiResponse("Event not in list: "+ id);
    }

     @GetMapping("/findEvent/{id}")
    public ArrayList<Event> findEvent(@PathVariable int id)
    {
        ArrayList<Event> matchingEvent = new ArrayList<>();

        for (Event loop : events) {
            if (loop.getId() == id) {
                matchingEvent.add(loop);
            }
        }
        return matchingEvent;
    }
}
