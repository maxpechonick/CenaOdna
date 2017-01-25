import {Component, Input} from "@angular/core";
import {FileUploader} from "ng2-file-upload";
import {UserService} from "../../services/user.service";

const URL = 'http://localhost:8080/api/protected/user/upload';

@Component({
  selector: 'image-upload',
  templateUrl: './upload.component.html'
})
export class ImageUploadComponent {
  public uploader: FileUploader;
  @Input() public image: string;
  @Input() public preview: boolean;

  public uploaded: boolean = false;

  constructor(private userServise: UserService) {
    let token: string;
    token = 'Bearer ' + localStorage.getItem('token');
    this.uploader = new FileUploader({url: URL, authToken: token, authTokenHeader: 'X-Authorization'});
    this.uploader.onCompleteItem = (item: any, response: any, status: any, headers: any) => {
      if (response && JSON.parse(response) && JSON.parse(response).image) {
        this.image = JSON.parse(response).image;
        userServise.updateAuthUser(JSON.parse(response));
      }
      this.uploaded = false;
    };
  }

  public upload() {
    let length = this.uploader.queue.length;
    if (length > 0) {
      this.uploaded = true;
      let lastItem = this.uploader.queue[length - 1];
      let queue = this.uploader.queue;
      queue[0] = lastItem;
      this.uploader.queue = queue;
      this.uploader.uploadAll();
    }
  }
}
