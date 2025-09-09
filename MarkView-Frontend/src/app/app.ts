import {Component, inject, signal} from '@angular/core';
import {ThemeService} from "../theme/theme.service";
import {Button} from "primeng/button";
import {HeaderComponent} from "./header.component/header.component";
import { FormsModule, NgForm } from "@angular/forms";
import {ApiService} from "./api-service";
import {MessageService} from "primeng/api";
import {Toast} from "primeng/toast";
import {Dialog} from "primeng/dialog";
import {
  FileSelectEvent,
  FileUpload,
  FileUploadEvent,
  FileUploadHandlerEvent
} from "primeng/fileupload";


@Component({
  selector: 'app-root',
  imports: [
    HeaderComponent,
    Button,
    FormsModule,
    Toast,
    Dialog,
    FileUpload
  ],
  templateUrl: './app.html',
  styleUrl: './app.css',
  providers:[MessageService]
})
export class App {
  private _apiService = inject(ApiService);
  private _messageService = inject(MessageService);
  selectedFile: File | null = null;
  isUploaded = signal(false);
  htmlContent = signal<string>("");
  visible=false;


  onFileSelect(event: any) {
    this.selectedFile = event.target.files[0];
  }

  onUpload() {
      // this.isUploaded.set(true);
    if(this.selectedFile){

      console.log("upload button typed")
      const formData = new FormData();
      formData.append('file', this.selectedFile);
      this._apiService.upload(formData).subscribe(res => {

        this.isUploaded.set(true);
        this._messageService.add({ severity: 'info', summary: "Upload" +
              " Successfull", detail: 'Markdown uploaded successfully', life: 3000 })
      });
    }



  }

  toHTML() {
      this._apiService.convert().subscribe(res=>{
        console.log(res);
        this.htmlContent.set(res.html);
      });
      }

  toggleDialog() {
    this.visible=true;
  }

   copyToClipboard(): void {
    navigator.clipboard.writeText(this.htmlContent())
        .then(() => {
          this._messageService.add({ severity: 'success', summary: "Copied!!", detail:"Copied to Clipboard", life: 3000 })

        })
     this._messageService.add({ severity: 'danger', summary: "Unsuccessfully", detail:"Failed to Copy", life: 3000 })

  }

  uploadHandler(event: FileUploadHandlerEvent) {
    console.log("File has been assigned")
    this.selectedFile = event.files[0];
    this.onUpload()
  }
}
