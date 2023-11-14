import { Component } from "@angular/core";
import { PlantService } from "../service/plants.service";

@Component({
  selector: "app-footer",
  templateUrl: "./footer.component.html",
  styleUrls: ["./footer.component.css"],
})
export class FooterComponent {
  constructor(private plantService: PlantService) {}

  ngOnInit(): void {}

  getLogo() {
    return this.plantService.getImageUrlString("logo");
  }
}
