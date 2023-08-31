import { Component, OnInit } from '@angular/core';
import { Product } from '../../domain/product';
import { ProductService } from '../../service/productservice';
import { SelectItem } from 'primeng/api';
import { MessageService } from 'primeng/api';

@Component({
templateUrl: './tableeditdemo.html',
providers: [MessageService],
styles: [`
:host ::ng-deep .p-cell-editing {
padding-top: 0 !important;
padding-bottom: 0 !important;
}
`]
})
export class TableEditDemo implements OnInit {

    products1: Product[];

    products2: Product[];

    statuses: SelectItem[];

    clonedProducts: { [s: string]: Product; } = {};

    constructor(private productService: ProductService, private messageService: MessageService) { }

    ngOnInit() {
        this.productService.getProductsSmall().then(data => this.products1 = data);
        this.productService.getProductsSmall().then(data => this.products2 = data);

        this.statuses = [{label: 'In Stock', value: 'INSTOCK'},{label: 'Low Stock', value: 'LOWSTOCK'},{label: 'Out of Stock', value: 'OUTOFSTOCK'}]
    }

    onRowEditInit(product: Product) {
        this.clonedProducts[product.id] = {...product};
    }

    onRowEditSave(product: Product) {
        if (product.price > 0) {
            delete this.clonedProducts[product.id];
            this.messageService.add({severity:'success', summary: 'Success', detail:'Product is updated'});
        }
        else {
            this.messageService.add({severity:'error', summary: 'Error', detail:'Invalid Price'});
        }
    }

    onRowEditCancel(product: Product, index: number) {
        this.products2[index] = this.clonedProducts[product.id];
        delete this.clonedProducts[product.id];
    }

}

<p-toast></p-toast>

<div class="card">
    <h5>Cell Editing</h5>
    <p-table [value]="products1" dataKey="id" [tableStyle]="{'min-width': '50rem'}">
        <ng-template pTemplate="header">
            <tr>
                <th style="width:25%">Code</th>
                <th style="width:25%">Name</th>
                <th style="width:25%">Category</th>
                <th style="width:25%">Price</th>
            </tr>
        </ng-template>
        <ng-template pTemplate="body" let-product>
            <tr>
                <td pEditableColumn>
                    <p-cellEditor>
                        <ng-template pTemplate="input">
                            <input pInputText type="text" [(ngModel)]="product.code">
                        </ng-template>
                        <ng-template pTemplate="output">
                            {{product.code}}
                        </ng-template>
                    </p-cellEditor>
                </td>
                <td pEditableColumn>
                    <p-cellEditor>
                        <ng-template pTemplate="input">
                            <input pInputText type="text" [(ngModel)]="product.name" required>
                        </ng-template>
                        <ng-template pTemplate="output">
                            {{product.name}}
                        </ng-template>
                    </p-cellEditor>
                </td>
                <td pEditableColumn>
                    <p-cellEditor>
                        <ng-template pTemplate="input">
                            <input pInputText [(ngModel)]="product.inventoryStatus">
                        </ng-template>
                        <ng-template pTemplate="output">
                            {{product.inventoryStatus}}
                        </ng-template>
                    </p-cellEditor>
                </td>
                <td pEditableColumn>
                    <p-cellEditor>
                        <ng-template pTemplate="input">
                            <input pInputText type="text" [(ngModel)]="product.price">
                        </ng-template>
                        <ng-template pTemplate="output">
                            {{product.price | currency: 'USD'}}
                        </ng-template>
                    </p-cellEditor>
                </td>
            </tr>
        </ng-template>
    </p-table>
</div>

<div class="card">
<h5>Row Editing</h5>
    <p-table [value]="products2" dataKey="id" editMode="row" [tableStyle]="{'min-width': '50rem'}">
        <ng-template pTemplate="header">
            <tr>
                <th style="width:20%">Code</th>
                <th style="width:20%">Name</th>
                <th style="width:20%">Category</th>
                <th style="width:20%">Price</th>
                <th style="width:20%"></th>
            </tr>
        </ng-template>
        <ng-template pTemplate="body" let-product let-editing="editing" let-ri="rowIndex">
            <tr [pEditableRow]="product">
                <td>
                    <p-cellEditor>
                        <ng-template pTemplate="input">
                            <input pInputText type="text" [(ngModel)]="product.code">
                        </ng-template>
                        <ng-template pTemplate="output">
                            {{product.code}}
                        </ng-template>
                    </p-cellEditor>
                </td>
                <td>
                    <p-cellEditor>
                        <ng-template pTemplate="input">
                            <input pInputText type="text" [(ngModel)]="product.name" required>
                        </ng-template>
                        <ng-template pTemplate="output">
                            {{product.name}}
                        </ng-template>
                    </p-cellEditor>
                </td>
                <td>
                    <p-cellEditor>
                        <ng-template pTemplate="input">
                            <p-dropdown [options]="statuses" appendTo="body" [(ngModel)]="product.inventoryStatus" [style]="{'width':'100%'}"></p-dropdown>
                        </ng-template>
                        <ng-template pTemplate="output">
                            {{product.inventoryStatus}}
                        </ng-template>
                    </p-cellEditor>
                </td>
                <td>
                    <p-cellEditor>
                        <ng-template pTemplate="input">
                            <input pInputText type="text" [(ngModel)]="product.price">
                        </ng-template>
                        <ng-template pTemplate="output">
                            {{product.price | currency: 'USD'}}
                        </ng-template>
                    </p-cellEditor>
                </td>
                <td>
                    <div class="flex align-items-center justify-content-center gap-2">
                        <button *ngIf="!editing" pButton pRipple type="button" pInitEditableRow icon="pi pi-pencil" (click)="onRowEditInit(product)" class="p-button-rounded p-button-text"></button>
                        <button *ngIf="editing" pButton pRipple type="button" pSaveEditableRow icon="pi pi-check" (click)="onRowEditSave(product)" class="p-button-rounded p-button-text p-button-success mr-2"></button>
                        <button *ngIf="editing" pButton pRipple type="button" pCancelEditableRow icon="pi pi-times" (click)="onRowEditCancel(product, ri)" class="p-button-rounded p-button-text p-button-danger"></button>
                    </div>
                </td>
            </tr>
        </ng-template>
    </p-table>
</div>
