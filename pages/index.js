import React from "react";

import gravityLineJs from "./gravityLineJs";
import meanderLine from "./meanderLine";

const defaultValues = {
  stroke: 1,
  color: "dodgerblue",
  numpoints: 100,
  numlines: 120,
  opacity: 0.5,
  useCmyLines: false
};

class ExamplePage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      editedCode: meanderLine(defaultValues),
      values: defaultValues
    };
  }

  changeCode = e => {
    this.setState({ editedCode: e.target.value });
  };

  updateValue = (key, val) => {
    const updatedValues = Object.assign({}, this.state.values);
    updatedValues[key] = val;
    this.setState({ values: updatedValues });
  };

  regenerate = () => {
    const { values } = this.state;
    this.setState({ editedCode: meanderLine(values) });
  };

  render() {
    const { editedCode, values } = this.state;
    return (
      <div style={{ background: "lightgray" }}>
        Hello example program!
        <br />
        <button onClick={this.regenerate}>Regenerate</button>
        <br />
        Stroke width :{" "}
        <input
          type="text"
          onChange={e => this.updateValue("stroke", e.target.value)}
          value={values.stroke}
        />
        <br />
        Color :{" "}
        <input
          type="color"
          onChange={e => this.updateValue("color", e.target.value)}
          value={values.color}
        />
        <br />
        Use CMY Lines :{" "}
        <input
          type="checkbox"
          checked={values.useCmyLines}
          onChange={e => this.updateValue("useCmyLines", e.target.checked)}
          value={values.useCmyLines}
        />
        <br />
        Points per line :{" "}
        <input
          type="number"
          onChange={e => this.updateValue("numpoints", e.target.value)}
          value={values.numpoints}
        />
        <br />
        Line count :{" "}
        <input
          type="number"
          onChange={e => this.updateValue("numlines", e.target.value)}
          value={values.numlines}
        />
        <br />
        Opacity :{" "}
        <input
          type="text"
          onChange={e => this.updateValue("opacity", e.target.value)}
          value={values.opacity}
        />
        <br />
        <textarea
          style={{
            width: "100%",
            resize: "none",
            height: "10em",
            fontFamily: "monospace"
          }}
          onChange={this.changeCode}
          value={editedCode}
        />
        <div
          style={{
            background: "white"
          }}
          dangerouslySetInnerHTML={{ __html: editedCode }}
        />
      </div>
    );
  }
}

export default ExamplePage;
