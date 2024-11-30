import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';

import { provideHttpClient, withFetch } from '@angular/common/http';
import { AppComponent } from './app/app.component';
import { bootstrapApplication } from '@angular/platform-browser';



bootstrapApplication(AppComponent, {
  providers: [provideHttpClient(withFetch())]
}).catch(err => console.error(err));