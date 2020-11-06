import { LitElement, html, css, customElement } from 'lit-element';

import * as AboutEndpoint from '../../generated/AboutEndpoint';
import AboutData from '../../generated/com/xdev/views/about/AboutData';


@customElement('about-view')
export class AboutView extends LitElement {

  data: AboutData = {
    version: "",
    buildNumber: ""
  }

  static get styles() {
    return css`
      :host {
        display: block;
        padding: var(--lumo-space-m) var(--lumo-space-l);
      }
    `;
  }

  render() {
    return html`
      <table style="border: none">
        <tr>
          <td>Version</td>
          <td>${this.data.version}</td>
        </tr>
        <tr>
          <td>BuildNumber</td>
          <td>${this.data.buildNumber}</td>
        </tr>
      </table>
    `;
  }

  async firstUpdated(changedProperties: any) {
    super.firstUpdated(changedProperties);

    this.data = await AboutEndpoint.get();

    this.requestUpdate();
  }
}
