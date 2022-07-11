import {Product} from "./product";

export class Cart {
  id: number;
  product: Product;
  quantity: number;

  constructor(product: Product, quantity: number, id: number) {
    this.id = id;
    this.product = product;
    this.quantity = quantity;

  }
}
