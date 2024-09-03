import { Component, OnInit } from "@angular/core";
import { BaseListCtl } from "../base-list.component";
import { ServiceLocatorService } from "../service-locator.service";
import { ActivatedRoute } from "@angular/router";
import { HttpClient } from "@angular/common/http";

@Component({
  selector: "app-assettrackinglist",
  templateUrl: "./assettrackinglist.component.html",
  styleUrls: ["./assettrackinglist.component.css"],
})
export class AssetTrackingListComponent extends BaseListCtl implements OnInit {

  public form = {
    error: false,
    message: null,
    preload: {
      assettrackingList: [],
    },
    data: { id: null },

    searchParams: {
      longitude: "",
      latitude: "",
      trackingDate: "",
      assetId: null,
      
    },
    searchMessage: null,
    list: [],
    pageNo: 0,
  };

  constructor(public locator: ServiceLocatorService,public route: ActivatedRoute,private httpClient: HttpClient) {
    super(locator.endpoints.ASSETTRACKING, locator, route);
  }

  ngOnInit() {
    super.ngOnInit();
  }

  formatDate(event: any) {
    const selectedDate = new Date(event);
    const formattedDate = selectedDate.toISOString().split("T")[0];
    this.form.searchParams.trackingDate = formattedDate;
  }

  convertToLocalDate(dateString: string): string {
    const date = new Date(dateString);

    const options: any = { year: "numeric", month: "2-digit", day: "2-digit" };
    return date.toLocaleDateString(undefined, options);
  }

  submit() {
    this.form.pageNo = 0;

    this.search();
  }

  search() {
    this.form.searchMessage = null;

    super.search();
  }

  validateAlphabetInput(event: KeyboardEvent) {
    const str = event.key;
   
    if (!/^[a-zA-Z\s]*$/.test(str)) {
      event.preventDefault();
    }
  }

  validateNumericInput(event: KeyboardEvent) {
    const str = event.key;
   
    if (!/^[0-9]*\.?[0-9]*$/.test(str)) {
      event.preventDefault();
    }
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
