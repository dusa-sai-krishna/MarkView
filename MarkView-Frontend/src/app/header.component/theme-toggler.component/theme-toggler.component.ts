import {Component, inject} from '@angular/core';
import {ThemeService} from "../../../theme/theme.service";
import {Button} from "primeng/button";

@Component({
  selector: 'app-theme-toggler',
  imports: [
    Button
  ],
  templateUrl: './theme-toggler.component.html',
  styleUrl: './theme-toggler.component.css'
})
export class ThemeTogglerComponent {
  private _themeService = inject(ThemeService)
  public theme = this._themeService.theme;


  onToggleTheme() {
    this._themeService.toggleDarkMode();
  }
}
