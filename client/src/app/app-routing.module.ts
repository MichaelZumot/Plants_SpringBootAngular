import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';

const routes: Routes = [
  {
    path: 'gallery',
    component: AboutComponent
  },
  {
    path: 'about',
    component: AboutComponent
  },
  {
    path: 'home',
    component: HomeComponent
  }
];


@NgModule({
  imports: [HttpClientModule, RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
