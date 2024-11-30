import { Component, OnInit } from '@angular/core';
import { TourService } from '../../services/tour.service';
import { Tour } from '../../models/tour.model';

@Component({
  selector: 'app-tour',
  templateUrl: './tour.component.html',
  styleUrl: './tour.component.css'
})
export class TourComponent implements OnInit {
  
  tours: Tour[] = [];

  constructor(private tourService: TourService) {}

  ngOnInit(): void {
      this.loadTours();
  }

  loadTours(): void {
      this.tourService.getTours().subscribe(data => {
          this.tours = data;
      });
  }
}
