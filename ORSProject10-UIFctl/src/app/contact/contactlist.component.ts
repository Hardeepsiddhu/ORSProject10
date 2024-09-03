import { Component, OnInit } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-contactlist',
  templateUrl: './contactlist.component.html',
  styleUrls: ['./contactlist.component.css']
})
export class ContactlistComponent extends BaseListCtl implements OnInit {

  public form = {
    error: false,
    message: null,
    preload: {
      cityList: [] 
     
    },
    data: { id: null },
   
    searchParams: {
   
      mobileNo: "",
      dob: "",
      cityId: null, 
      name:"",
      
    },
    searchMessage: null,
    list: [],
    pageNo: 0
  };
 


  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.CONTACT, locator, route);
  }

  ngOnInit() {
    super.ngOnInit();
  }


  validateMobileInput(event: KeyboardEvent) {
    const values = (event.target as HTMLInputElement).value + event.key;
    if (!/^[6-9][0-9]{0,9}$/.test(values)) {
        event.preventDefault();
    }

     }
  
  validateAlphabetInput(event: KeyboardEvent) {
    console.log(event);
    const str = event.key ;
    
    console.log(str);
    if (!/^[a-zA-Z\s]*$/.test(str)) {
      event.preventDefault();
    }
  }
 
  submit() {
   
    this.form.pageNo = 0;
    
    this.search();
  }


 
  search() {
   
    this.form.searchMessage = null;
    
    super.search();
  }
}


