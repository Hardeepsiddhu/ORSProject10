import { Component, OnInit } from "@angular/core";
import { BaseCtl } from "../base.component";
import { FormGroupName } from "@angular/forms";
import { ServiceLocatorService } from "../service-locator.service";
import { ActivatedRoute } from "@angular/router";
import { HttpClient } from "@angular/common/http";

@Component({
  selector: "app-assettracking",
  templateUrl: "./assettracking.component.html",
  styleUrls: ["./assettracking.component.css"],
})
export class AssetTrackingComponent extends BaseCtl implements OnInit {
  
  constructor(public locator: ServiceLocatorService,public route: ActivatedRoute,private httpClient: HttpClient) {
    super(locator.endpoints.ASSETTRACKING, locator, route);
  }

  submit() {
    var _self = this;

    this.serviceLocator.httpService.post(
      this.api.save,
      this.form.data,
      function (res) {
        _self.form.message = "";
        _self.form.inputerror = {};

        if (res.success) {
          _self.form.error = false;
          _self.form.message = "Data is saved";
          _self.form.data.id = res.result.data;
        } else {
          _self.form.error = true;
          if (res.result.inputerror) {
            _self.form.inputerror = res.result.inputerror;
          }
          _self.form.message = res.result.message;
        }
      }
    );
  }

  onUpload(userform: FormData) {
    this.submit();
  }
  parseDate(dateString: string): Date {
    if (dateString) {
      return new Date(dateString);
    }
    return null;
  }

  populateForm(form, data) {
    form.id = data.id;

    form.longitude = data.longitude;
    form.latitude = data.latitude;
    form.trackingDate = data.trackingDate;
    form.assetId = data.assetId;
  }

  validateDecimalInput(event: KeyboardEvent) {
    const str = event.key;
    console.log(str);
    if (!/^\d$|^\.$/.test(str)) {
      event.preventDefault();
    }
  }

  validateMobileInput(event: KeyboardEvent) {
    const newValue = (event.target as HTMLInputElement).value + event.key;
    if (!/^[6-9][0-9]{0,9}$/.test(newValue)) {
      event.preventDefault();
    }
  }
}
