import { Component, OnInit } from '@angular/core';
import {ProductServiceService} from '../product-service.service'
import {Product} from '../product/product';
import { OrderEO } from './OrderEO';
import { InventoryService } from '../inventory.service';
import { User } from '../user';
@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {

  public dataSource:Product[];
  currentUser:User;
  public  displayedColumns: string[] = ['position','name', 'description', 'price','addToCart'];
  constructor(private _productService:ProductServiceService,private _inventoryService:InventoryService) { }

  ngOnInit() {
    this._productService.getAllProduct().subscribe( (data:Product[])=>{
      this.dataSource=data;
      console.log(this.dataSource);
    })
  }

  addToCart(element:Product){
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this._inventoryService.addOrder(this.currentUser.username,element.id).subscribe(
      (data:Product)=>{
        console.log("Added to cart");
      },
    (error:any) =>{
      console.log("Error -----"+error._productService);
    },
   ()=>{
     console.log(" Added to cart");
   }
    );
  }
}
