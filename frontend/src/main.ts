import { bootstrapApplication } from '@angular/platform-browser';
import 'zone.js'; // Included for Angular's change detection
import { provideHttpClient } from '@angular/common/http';
import { AppComponent } from './app/app.component';

bootstrapApplication(AppComponent, {
  providers: [provideHttpClient()]
}).catch(err => console.error(err));
