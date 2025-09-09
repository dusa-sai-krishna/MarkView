import { Component } from '@angular/core';
import {
  ThemeTogglerComponent
} from "./theme-toggler.component/theme-toggler.component";

@Component({
  selector: 'app-header',
  imports: [
    ThemeTogglerComponent

  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

}
