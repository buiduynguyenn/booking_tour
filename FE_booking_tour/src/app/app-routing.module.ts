import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TourComponent } from './components/tour/tour.component';
import { UserComponent } from './components/user/user.component';
import { ReviewComponent } from './components/review/review.component';
import { BookingComponent } from './components/booking/booking.component';

const routes: Routes = [
  { path: 'tours', component: TourComponent },
  { path: 'users', component: UserComponent },
  { path: 'reviews', component: ReviewComponent }, 
  { path: 'bookings', component: BookingComponent },
  { path: '', redirectTo: '/tours', pathMatch: 'full' }, // Mặc định chuyển hướng đến /tours
  { path: '**', redirectTo: '/tours' } // Xử lý route không tồn tại
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
